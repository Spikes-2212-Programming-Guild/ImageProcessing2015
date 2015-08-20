package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.ArmDown;
import org.usfirst.frc.team2212.robot.commands.ArmUp;
import org.usfirst.frc.team2212.robot.other.LimitSwitch;
import org.usfirst.frc.team2212.robot.other.Piston;
import org.usfirst.frc.team2212.robot.other.StoppableSubsystem;
import org.usfirst.frc.team2212.robot.other.Piston.InverseSolenoidCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends StoppableSubsystem {

	private Piston piston;
	private LimitSwitch down, up;
	public static final Piston.InverseSolenoidCommand inverseSolenoidsCommand = Robot.ARM
			.makeNewInvesreSolenoidCommand();
	public static final ArmUp armUp = new ArmUp();
	public static final ArmDown armDown = new ArmDown();

	public Arm(Piston piston, LimitSwitch up, LimitSwitch down) {
		super();
		this.piston = piston;
		this.down = down;
		this.up = up;

	}

	/**
	 * opens the piston to bring the arm up
	 */
	public void goUp() {
		piston.open();
	}

	/**
	 * closes the piston to bring the arm down
	 */
	public void goDown() { // MOSES!!!!!!!!!
		piston.close();
	}

	/**
	 * 
	 * @see org.usfirst.frc.team2212.robot.other.Piston#stop()
	 */
	@Override
	public void stop() {
		piston.stop();
	}

	/**
	 * 
	 * @see org.usfirst.frc.team2212.robot.other.Piston#inverseSolenoids()
	 */
	public void inverseSolenoids() {
		piston.inverseSolenoids();
	}

	/**
	 * @return
	 * @see org.usfirst.frc.team2212.robot.other.Piston#makeNewInvesreSolenoidCommand()
	 */
	public InverseSolenoidCommand makeNewInvesreSolenoidCommand() {
		return piston.makeNewInvesreSolenoidCommand();
	}

	public boolean isUp() {
		return up.isPressed();
	}

	public boolean isDown() {
		return down.isPressed();
	}
}
