package com.raon.jooq.custom.generator;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

// QueryDSL의 Q클래스처럼 클래스명에 J를 붙여주는 클래스
public class JPrefixGeneratorStrategy extends DefaultGeneratorStrategy {

	@Override
	public String getJavaClassName(final Definition definition, final Mode mode) {
		if (mode == Mode.DEFAULT) {
			return "J" + super.getJavaClassName(definition, mode);
		}
		return super.getJavaClassName(definition, mode);
	}
}