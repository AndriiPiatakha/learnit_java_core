package com.itbulls.learnit.javacore.optional;

import java.util.Optional;

public class Solution {

	public static void main(String[] args) {
		var computer = new Computer();
		computer.getUsbDrive().ifPresentOrElse(drive -> {
			drive.getWriteProtectSwitch()
				.ifPresent(switcher -> System.out.println(switcher.isSwitchedOn()));
		}, () -> System.out.println("No USB drive found"));

	}

	private static class Computer {

		private UsbDrive usbDrive;

		public Optional<UsbDrive> getUsbDrive() {
			return Optional.ofNullable(this.usbDrive);
		}

	}

	private static class UsbDrive {

		private WriteProtectSwitch writeProtectSwitch;

		public Optional<WriteProtectSwitch> getWriteProtectSwitch() {
			return Optional.ofNullable(this.writeProtectSwitch);
		}

	}

	private static class WriteProtectSwitch {

		private boolean switchedOn;
		
		public boolean isSwitchedOn() {
			return this.switchedOn;
		}

	}

}
