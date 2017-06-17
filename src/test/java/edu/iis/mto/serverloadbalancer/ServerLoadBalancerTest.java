package edu.iis.mto.serverloadbalancer;


import static edu.iis.mto.serverloadbalancer.LoadPercentageMatcher.hasLoadPercentageOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

	private HasVMachineMatcher hasVMachine(VMachine vMachine) {
		return null;
	}

	private List<VMachine> vMachineList(VMachine vMachine) {
		return null;
	}

	private VMachine create(VMachineBuilder size) {
		return null;
	}

	private VMachineBuilder vMachnine() {
		return null;
	}

	private void balance(List<Server> servers, List<VMachine> vMachines) {
	}

	private List<VMachine> vmEmptyList() {
		return new ArrayList<VMachine>();
	}

	private List<Server> serverList(Server server) {
		List<Server> servers = new ArrayList<Server>();
		servers.add(server);
		return servers;
	}

	private Server create(ServerBuilder capacity) {
		return capacity.build();
	}

	private ServerBuilder server() {
		return new ServerBuilder();
	}
}
