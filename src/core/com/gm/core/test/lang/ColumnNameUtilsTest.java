/**
 * 
 */
package com.gm.core.test.lang;

import com.gm.core.sql.ColumnNameUtils;

/**
 */
public class ColumnNameUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] ts = new String[] { "abc", "Abc", "ABC", "a_bc", "ab_c", "AB_C", "AB_C_D_E", "ab_c_d_Z_Fzdfdf" };
		// StopWatch watch = new StopWatch();
		for (int i = 0; i < 1; i++) {
			for (String s : ts) {
				System.out.println(ColumnNameUtils.toFieldName(s));
			}
		}
	}
}
