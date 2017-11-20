package com.oracleoaec.common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
	//设置占位符
	void setValues(PreparedStatement pstmt) throws SQLException;
}
