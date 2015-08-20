package org.usfirst.frc.team2212.robot.other;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class GeneralGearbox {
	private SpeedController[] controllers;

	public GeneralGearbox(SpeedController... controllers) {
		this.controllers = controllers;
	}

	public GeneralGearbox(int... ports) {
		this.controllers = new SpeedController[ports.length];
		for (int i = 0; i < controllers.length; i++) {
			controllers[i] = new Talon(ports[i]);
		}
	}

	public void set(double speed) {
		for (SpeedController sc : controllers) {
			sc.set(speed);
		}
	}
}
