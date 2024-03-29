package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.other.StoppableSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Stop extends Command {

	private StoppableSubsystem system;

	public Stop(StoppableSubsystem system) {
		this.system = system;
		requires(system);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		system.stop();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
