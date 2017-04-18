/*
The MIT License (MIT)

Copyright (c) 2014 Manni Wood

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package com.games.world.mybatis.utils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
//import org.postgresql.util.PGobject;
import org.apache.ibatis.type.TypeHandler;

/**
 */
@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(Integer.class)
public class ZeroIfNullHandler implements TypeHandler<Integer> {

    @Override
    public Integer getResult(ResultSet rs, String columnName) throws SQLException {
        return (rs.getString(columnName) == null) ?0 : rs.getInt(columnName); 
    }

    @Override
    public Integer getResult(ResultSet rs, int columnIndex) throws SQLException {
        return (rs.getString(columnIndex) == null) ? 0 : rs.getInt(columnIndex);
    }

    @Override
    public Integer getResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        return (cs.getString(columnIndex) == null) ? 0 : cs.getInt(columnIndex);
    }

    @Override
    public void setParameter(PreparedStatement ps, int arg1, Integer str,
            JdbcType jdbcType) throws SQLException {
    }
}