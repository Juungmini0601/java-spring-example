package com.raon.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 1.
 */
@ToString
@Getter
@AllArgsConstructor
public class SerialUID implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private String v1;

	@Serial
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		System.out.println("hi");
	}
}
