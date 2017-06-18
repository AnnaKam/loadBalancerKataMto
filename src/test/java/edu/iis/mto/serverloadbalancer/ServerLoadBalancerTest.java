package edu.iis.mto.serverloadbalancer;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static edu.iis.mto.serverloadbalancer.HasVMachineMatcher.hasVMachine;
import static edu.iis.mto.serverloadbalancer.LoadPercentageMatcher.hasLoadPercentageOf;
import static edu.iis.mto.serverloadbalancer.ServerBuilder.server;
import static edu.iis.mto.serverloadbalancer.VMNumberMatcher.hasMachineCountOf;
import static edu.iis.mto.serverloadbalancer.VMachineBuilder.vMachnine;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class ServerLoadBalancerTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

	@Test
	public void serverWithoutMachineTest() throws Exception {
		Server server = create(server().capacity(10));
		balance(paramsToList(server), vmEmptyList());
		assertThat(server, hasLoadPercentageOf(0.0d));
	}

	@Test
	public void serverWithOneMachineFor100Test() throws Exception {
		Server server = create(server().capacity(10));
		VMachine vMachine = create(vMachnine().size(10));
		balance(paramsToList(server), paramsToList(vMachine));
		assertThat(server, hasLoadPercentageOf(100.0d));
		assertThat(server, hasVMachine(vMachine));
	}

	@Test
	public void serverWithOneMachineFor10Test() throws Exception {
		Server server = create(server().capacity(10));
		VMachine vMachine = create(vMachnine().size(1));
		balance(paramsToList(server), paramsToList(vMachine));
		assertThat(server, hasLoadPercentageOf(10.0d));
		assertThat(server, hasVMachine(vMachine));
	}

	@Test
	public void serverWithTwoMachinesTest() throws Exception {
		Server server = create(server().capacity(10));
		VMachine vMachine1 = create(vMachnine().size(1));
		VMachine vMachine2 = create(vMachnine().size(2));
		balance(paramsToList(server), paramsToList(vMachine1, vMachine2));
		assertThat(server, hasLoadPercentageOf(30.0d));
		assertThat(server, hasVMachine(vMachine1));
		assertThat(server, hasVMachine(vMachine2));
		assertThat(server, hasMachineCountOf(2));
	}

	@Test
	public void twoServersOneMachineTest() throws Exception {
		Server moreSpaceServer = create(server().capacity(10).load(10.0d));
		Server lessSpaceServer = create(server().capacity(10).load(50.0d));
		VMachine vMachine = create(vMachnine().size(3));
		balance(paramsToList(lessSpaceServer, moreSpaceServer), paramsToList(vMachine));
		assertThat(moreSpaceServer, hasVMachine(vMachine));
	}

	@Test
	public void noSpaceForVMachineTest() throws Exception {
		Server server = create(server().capacity(10).load(80.0d));
		VMachine vMachine = create(vMachnine().size(4));
		balance(paramsToList(server), paramsToList(vMachine));
		assertThat(server, not(hasVMachine(vMachine)));
	}

	@Test
	public void serversAndVMachinesCombinationTest() throws Exception {
		Server server1 = create(server().capacity(4));
		Server server2 = create(server().capacity(10));

		VMachine vMachine1 = create(vMachnine().size(5));
		VMachine vMachine2 = create(vMachnine().size(1));
		VMachine vMachine3 = create(vMachnine().size(2));

		balance(paramsToList(server1, server2), paramsToList(vMachine1, vMachine2, vMachine3));

		assertThat(server1, hasVMachine(vMachine2));
		assertThat(server2, hasVMachine(vMachine1));
		assertThat(server1, hasVMachine(vMachine3));

		assertThat(server2, hasLoadPercentageOf(50.0d));
		assertThat(server1, hasLoadPercentageOf(75.0d));
	}

	private void balance(List<Server> servers, List<VMachine> vMachines) {
		ServerLoadBalancer serverLoadBalancer = new ServerLoadBalancer();
		serverLoadBalancer.balance(servers, vMachines);
	}

	private List<VMachine> vmEmptyList() {
		return new ArrayList<VMachine>();
	}

	private <T> List<T> paramsToList(T...params) {
		List<T> list = new ArrayList<T>();
		Collections.addAll(list, params);
		return list;
	}

	private <T> T create (Builder<T> param){
		return param.build();
	}
}
