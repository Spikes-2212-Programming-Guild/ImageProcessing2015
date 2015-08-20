package org.usfirst.frc.team2212.robot.other;

import org.usfirst.frc.team2212.robot.commands.Stop;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class StoppableSubsystem extends Subsystem {
	public abstract void stop();

	public void initDefaultCommand() {
		setDefaultCommand(new Stop(this));
	}
}
