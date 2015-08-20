package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.other.GeneralGearbox;
import org.usfirst.frc.team2212.robot.other.StoppableSubsystem;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 */
public class Drivetrain extends StoppableSubsystem {
	GeneralGearbox left, right;

	public Drivetrain(GeneralGearbox left, GeneralGearbox right) {
		this.left = left;
		this.right = right;
	}

	public void turn(double speed) {
		left.set(speed);
		right.set(speed);
	}

	public void straight(double speed) {
		left.set(speed);
		right.set(-speed);
	}

	@Override
	public void stop() {
		straight(0);
	}
}
