package com.raon.io;

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
public class Student implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;

	private transient String password;
}
