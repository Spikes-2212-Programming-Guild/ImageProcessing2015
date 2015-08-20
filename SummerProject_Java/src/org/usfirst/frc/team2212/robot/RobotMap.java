package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {
	public static interface Ports {
		public static interface ArmPorts {
			public static final int SOL_CLOSE = 1, SOL_OPEN = 2;
		}

		public static interface LimitSwitches {
			public static final int ARM_UP = 1, ARM_DOWN = 2;
		}
	}

	public static interface Timeouts {
		public static final int GENERAL_TIMEOUT = 3;
	}
}
