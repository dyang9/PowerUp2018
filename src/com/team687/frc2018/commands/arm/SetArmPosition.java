package com.team687.frc2018.commands.arm;

import com.team687.frc2018.Robot;
import com.team687.frc2018.constants.SuperstructureConstants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Set arm position
 */

public class SetArmPosition extends Command {

    private double m_position;

    public SetArmPosition(double position) {
	requires(Robot.arm);
	m_position = position;
    }

    @Override
    protected void initialize() {
	SmartDashboard.putString("Current Arm Command", "SetArmPosition: " + m_position);
    }

    @Override
    protected void execute() {
	Robot.arm.setPosition(m_position);
    }

    @Override
    protected boolean isFinished() {
	return Math.abs(Robot.arm.getPosition() - m_position) < SuperstructureConstants.kArmTolerance;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
