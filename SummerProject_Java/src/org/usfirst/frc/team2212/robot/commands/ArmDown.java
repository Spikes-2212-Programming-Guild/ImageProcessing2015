package org.usfirst.frc.team2212.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2212.robot.Robot.ARM;

import org.usfirst.frc.team2212.robot.RobotMap.Timeouts;
/**
 *
 */
public class ArmDown extends Command {
	
    public ArmDown() {
    	requires(ARM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(Timeouts.GENERAL_TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!ARM.isDown()){
    		ARM.goDown();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ARM.isUp() || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	ARM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
