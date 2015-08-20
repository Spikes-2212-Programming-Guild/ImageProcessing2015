package org.usfirst.frc.team2212.robot.other;

import edu.wpi.first.wpilibj.DigitalInput;

public class LimitSwitch {
	public static enum State {
		NORMALLY_CLOSE, NORMALLY_OPEN;
		public static final State DEFAULT = NORMALLY_OPEN;
	}

	public final State state;
	public final DigitalInput sensor;

	public LimitSwitch(DigitalInput sensor, State state) {
		super();
		this.state = state == null ? State.DEFAULT : state;
		this.sensor = sensor;
	}

	public LimitSwitch(int port, State state) {
		this(new DigitalInput(port), state);
	}

	public LimitSwitch(DigitalInput sensor) {
		this(sensor, State.DEFAULT);
	}

	public LimitSwitch(int port) {
		this(new DigitalInput(port));
	}

	public boolean isCircuitClose() {
		return sensor.get();
	}

	public boolean isNormallyOpen() {
		return state == State.NORMALLY_OPEN;
	}

	public boolean isNormallyClose() {
		return state == State.NORMALLY_CLOSE;
	}

	public boolean isSetToDefaultState() {
		return state == State.DEFAULT;
	}

	public boolean isPressed() {
		return isCircuitClose() ^ isNormallyClose();
	}
}
