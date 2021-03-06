package com.team687.frc2018.commands.superstructure;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.team687.frc2018.constants.SuperstructureConstants;
import com.team687.frc2018.subsystems.ArmSimulation;
import com.team687.frc2018.subsystems.WristSimulation;

public class SuperstructureTest {

    public static ArmSimulation m_armSimulation = new ArmSimulation();
    public static WristSimulation m_wristSimulation = new WristSimulation();

    private double kEpsilon = 0.0001;

    public void stowSuperstructure() {
	System.out.println("StowSuperstructure");
	m_wristSimulation.setPosition(SuperstructureConstants.kWristStowPos);
	m_armSimulation.setPosition(SuperstructureConstants.kArmDownPos);
	if (m_armSimulation.getPosition() < SuperstructureConstants.kArmWristSafePos) {
	    assertTrue(m_wristSimulation.isWristSafe());
	}
	System.out.println("Wrist Position: " + m_wristSimulation.getPosition());
	System.out.println("Arm Position: " + m_armSimulation.getPosition());
    }

    @Test
    public void setIntakePosition() {
	System.out.println("SetIntakePosition");
	stowSuperstructure();
	m_wristSimulation.setPosition(SuperstructureConstants.kWristIntakePos);
	if (m_armSimulation.getPosition() < SuperstructureConstants.kArmWristSafePos) {
	    assertTrue(m_wristSimulation.isWristSafe());
	}
	System.out.println("Wrist Position: " + m_wristSimulation.getPosition());
	System.out.println("Arm Position: " + m_armSimulation.getPosition());
	System.out.println();
    }

    @Test
    public void setScalePositionForward() {
	System.out.println("SetScalePositionForward");
	stowSuperstructure();
	m_armSimulation.setPosition(SuperstructureConstants.kArmScaleMidPos);
	m_wristSimulation.setPosition(SuperstructureConstants.kWristScaleMidPos);
	if (m_armSimulation.getPosition() < SuperstructureConstants.kArmWristSafePos) {
	    assertTrue(m_wristSimulation.isWristSafe());
	}
	System.out.println("Wrist Position: " + m_wristSimulation.getPosition());
	System.out.println("Arm Position: " + m_armSimulation.getPosition());
	System.out.println();
    }

    @Test
    public void setScalePositionBackward() {
	System.out.println("SetScalePositionBackward");
	stowSuperstructure();
	m_armSimulation.setPosition(SuperstructureConstants.kArmScaleBackwardPos);
	m_wristSimulation.setPosition(SuperstructureConstants.kWristScaleBackwardPos);
	if (m_armSimulation.getPosition() < SuperstructureConstants.kArmWristSafePos) {
	    assertTrue(m_wristSimulation.isWristSafe());
	}
	System.out.println("Wrist Position: " + m_wristSimulation.getPosition());
	System.out.println("Arm Posiiton: " + m_armSimulation.getPosition());
	System.out.println();
    }

}
