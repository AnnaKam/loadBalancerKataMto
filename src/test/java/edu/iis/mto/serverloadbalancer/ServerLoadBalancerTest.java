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

public class ServerLoadBalancerTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

	@Test
	public void serverWithoutMachineTest() throws Exception {
		Server server = create(server().capacity(10));
		balance(serverList(server), vmEmptyList());
		assertThat(server, hasLoadPercentageOf(0.0d));
	}

	@Test
	public void serverWithOneMachineFor100Test() throws Exception {
		Server server = create(server().capacity(10));
		VMachine vMachine = create(vMachnine().size(10));
		balance(serverList(server), vMachineList(vMachine));
		assertThat(server, hasLoadPercentageOf(100.0d));
		assertThat(server, hasVMachine(vMachine));
	}

	@Test
	public void serverWithOneMachineFor10Test() throws Exception {
		Server server = create(server().capacity(10));
		VMachine vMachine = create(vMachnine().size(1));
		balance(serverList(server), vMachineList(vMachine));
		assertThat(server, hasLoadPercentageOf(10.0d));
		assertThat(server, hasVMachine(vMachine));
	}

	@Test
	public void serverWithTwoMachinesTest() throws Exception {
		Server server = create(server().capacity(10));
		VMachine vMachine1 = create(vMachnine().size(1));
		VMachine vMachine2 = create(vMachnine().size(2));
		balance(serverList(server), vMachineList(vMachine1, vMachine2));
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
		balance(serverList(lessSpaceServer, moreSpaceServer), vMachineList(vMachine));
		assertThat(moreSpaceServer, hasVMachine(vMachine));
	}

	private List<VMachine> vMachineList(VMachine...vMachines) {
		List<VMachine> vMachineList = new ArrayList<VMachine>();
		Collections.addAll(vMachineList, vMachines);
		return vMachineList;
	}

	private void balance(List<Server> servers, List<VMachine> vMachines) {
		ServerLoadBalancer serverLoadBalancer = new ServerLoadBalancer();
		serverLoadBalancer.balance(servers, vMachines);
	}

	private List<VMachine> vmEmptyList() {
		return new ArrayList<VMachine>();
	}

	private List<Server> serverList(Server...servers) {
		List<Server> serverList = new ArrayList<Server>();
		Collections.addAll(serverList, servers);
		return serverList;
	}

	private <T> T create (Builder<T> param){
		return param.build();
	}
}
