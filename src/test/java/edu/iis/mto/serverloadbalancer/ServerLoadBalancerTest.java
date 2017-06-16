package edu.iis.mto.serverloadbalancer;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.junit.Test;

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

	private LoadPercentageMatcher hasLoadPercentageOf(double v) {
		return null;
	}

	private void balance(List<Server> servers, List<VMachine> vMachines) {

	}

	private List<VMachine> vmEmptyList() {
		return null;
	}

	private List<Server> serverList(Server server) {
		return null;
	}

	private Server create(ServerBuilder capacity) {
		return capacity.build();
	}

	private ServerBuilder server() {
		return null;
	}
}
