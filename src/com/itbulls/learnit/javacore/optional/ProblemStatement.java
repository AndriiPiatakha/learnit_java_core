package com.itbulls.learnit.javacore.optional;

public class ProblemStatement {

	public static void main(String[] args) {
		var computer = new Computer();
		var usbDrive = computer.getUsbDrive();

		if (usbDrive != null) {
			var writeProtectSwitch = usbDrive.getWriteProtectSwitch();
			if (writeProtectSwitch != null) {
				// some code for write protect switch
			}
		} else {

		}

	}

	private static class Computer {

		private UsbDrive usbDrive;

		public UsbDrive getUsbDrive() {
			return this.usbDrive;
		}

	}

	private static class UsbDrive {

		private WriteProtectSwitch writeProtectSwitch;

		public WriteProtectSwitch getWriteProtectSwitch() {
			return writeProtectSwitch;
		}

	}

	private static class WriteProtectSwitch {

	}

}
