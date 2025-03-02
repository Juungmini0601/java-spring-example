package com.raon.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 1.
 */
class StudentTest {

	@Test
	@DisplayName("직렬화 테스트")
	void test1() throws Exception {
		SerialUID s = new SerialUID("v1");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.obj"))) {
			oos.writeObject(s);
			System.out.println("직렬화 완료");
		}
	}

	@Test
	@DisplayName("역직렬화 테스트")
	void test2() throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.obj"))) {
			Object o = ois.readObject();
			if (o instanceof SerialUID s) {
				System.out.println(s);
			}
		}
	}

	@Test
	@DisplayName("Base64 직렬화")
	void base64_직렬화() throws Exception {
		Student student = new Student("김정민", 28, "password");

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
			 ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			// 객체를 직렬화 해서 baos 내부에 있는 Byte 배열에 저장
			oos.writeObject(student);
			// 객체를 Base64 인코딩함
			String encoded = Base64.getEncoder().encodeToString(baos.toByteArray());
			System.out.println("encoded = " + encoded);

			try (
				BufferedWriter bw = new BufferedWriter(new FileWriter("student.base64.txt"))
			) {
				bw.write(encoded);
			}
		}
	}

	@Test
	@DisplayName("Base64 역직렬화")
	void base64_역직렬화() throws Exception {
		// 문자열 데이터를 읽어온다.
		try (BufferedReader br = new BufferedReader(new FileReader("student.base64.txt"))) {
			String encodedData = br.readLine();
			System.out.println("encodedData = " + encodedData);
			// 인코딩된 데이터를 이진스트림으로 디코딩한다.
			byte[] decoded = Base64.getDecoder().decode(encodedData);

			// 디코딩된 데이터를 객체로 역직렬화한다.
			try (
				ByteArrayInputStream bais = new ByteArrayInputStream(decoded);
				ObjectInputStream ois = new ObjectInputStream(bais)
			) {
				Object object = ois.readObject();
				// 객체가 맞는지 확인용
				if (object instanceof Student s) {
					System.out.println(s);
				}
			}
		}
	}

	@Test
	@DisplayName("직렬화 테스트")
	void test1_id() throws Exception {
		SerialUID object = new SerialUID("v1");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialUid.obj"))) {
			oos.writeObject(object);
			System.out.println("직렬화 완료");
		}
	}

	@Test
	@DisplayName("역직렬화 테스트")
	void test2_id() throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.obj"))) {
			Object o = ois.readObject();
			if (o instanceof SerialUID s) {
				System.out.println(s);
			}
		}
	}
}