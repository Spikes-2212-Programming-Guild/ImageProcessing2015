package org.usfirst.frc.team2212.robot.other;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

public class Piston {
	private Solenoid solOpen, solClose;
	public Piston(Solenoid openSolenoid, Solenoid closeSolenoid){
		this.solClose = closeSolenoid;
		this.solOpen = openSolenoid;
	}
	public Piston(int openSolenoidPort, int closeSolenoidPort){
		this(new Solenoid(openSolenoidPort), new Solenoid(closeSolenoidPort));
	}
	public void open(){
		solOpen.set(true);
		solClose.set(false);
	}
	public void close(){
		solOpen.set(false);
		solClose.set(true);
	}
	public void stop(){
		solClose.set(false);
		solOpen.set(false);
	}
	public void inverseSolenoids(){
		Solenoid tmp = solOpen;
		solOpen = solClose;
		solClose = tmp;
	}
	
	public InverseSolenoidCommand makeNewInvesreSolenoidCommand(){
		return new InverseSolenoidCommand(this);
	}
	
	public static class InverseSolenoidCommand extends Command{
		private Piston piston;
		private boolean finished;
		public InverseSolenoidCommand(Piston piston) {
			this.piston = piston;
		}
		
		@Override
		protected void initialize() {
			finished = false;
		}

		@Override
		protected void execute() {
			piston.inverseSolenoids();
			finished = true;
		}

		@Override
		protected boolean isFinished() {
			return finished;
		}

		@Override
		protected void end() {
			
		}

		@Override
		protected void interrupted() {
			end();
		}
	}
}
