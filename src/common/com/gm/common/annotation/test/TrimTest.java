package com.gm.common.annotation.test;

import com.gm.common.annotation.ApplyTo;
import com.gm.common.annotation.TrimValue;

public class TrimTest {

	public String str;

	public String getStr() {
		return str;
	}

	@TrimValue(ApplyTo.BEGIN)
	public void setStr(String str) {
		this.str = str;
	}

	public static void main(String[] args) {

	}
}
