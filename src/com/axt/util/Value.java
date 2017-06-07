/**
 * Copyright (c) 2011 bjaxt. All Rights Reserved.
 */

package com.axt.util;

/**
 * 描述: soa消息中的数据值
 * 版权:	 Copyright (c) 2011
 * 公司:	 中国民族证券
 * 作者:	 周海建
 * 版本:	 1.0
 * 创建日期: 2011-8-31
 */

public class Value 
{
	private int dataType = DataType.DATA_T_NULL;
	private Object value = null;
	
	/* construction */
	public Value()
	{
	}
	
	public Value(Integer value)
	{
		if (value != null)
		{
			this.dataType = DataType.DATA_T_INT32;
			this.value = value;
		}
	}
	
	public Value(Long value)
	{
		if (value != null) 
		{
			this.dataType = DataType.DATA_T_INT64;
			this.value = value;
		}
	}
	
	public Value(Float value)
	{
		if (value != null)
		{
			this.dataType = DataType.DATA_T_FLOAT;
			this.value = value;
		}
	}
	
	public Value(Double value)
	{
		if (value != null)
		{
			this.dataType = DataType.DATA_T_DOUBLE;
			this.value = value;
		}
	}
	
	public Value(String value)
	{
		if (value != null)
		{
			this.dataType = DataType.DATA_T_STRING;
			this.value = value;
		}
	}
	
	public Value(Buffer value)
	{
		if (value != null)
		{
			this.dataType = DataType.DATA_T_BINARY;
			this.value = value;
		}
	}
	
	public int getType()
	{
		return dataType;
	}
	
	public boolean isNull()
	{
		return DataType.DATA_T_NULL == dataType ? true : false;
	}
	
	public boolean isNumber()
	{
		if (DataType.DATA_T_INT32 == dataType ||
			DataType.DATA_T_INT64 == dataType ||
			DataType.DATA_T_FLOAT == dataType ||
			DataType.DATA_T_DOUBLE == dataType)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isString()
	{
		if (DataType.DATA_T_STRING == dataType ||
			DataType.DATA_T_LONG_STRING == dataType)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isBinary()
	{
		if (DataType.DATA_T_BINARY == dataType ||
			DataType.DATA_T_LONG_BINARY == dataType)
		{
			return true;
		}
		
		return false;
	}
	
	public int getSize()
	{
		switch (dataType)
		{
		case DataType.DATA_T_INT32:
			return 4;
		case DataType.DATA_T_INT64:
			return 8;
		case DataType.DATA_T_FLOAT:
			return 4;
		case DataType.DATA_T_DOUBLE:
			return 8;
		case DataType.DATA_T_STRING:
		case DataType.DATA_T_LONG_STRING:
			return ((String)value).getBytes().length;
		case DataType.DATA_T_BINARY:
		case DataType.DATA_T_LONG_BINARY:
			return ((Buffer)value).getSize();
		default:
			return 0;
		}
	}
	
	public byte[] getData()
	{
		Buffer buffer = toBinary();
		if (null == buffer)
			return null;
		
		return buffer.getData();
	}
	
	public int toInteger()
	{
		switch (dataType)
        {
        case DataType.DATA_T_INT32:
            return ((Integer)value).intValue();
        case DataType.DATA_T_INT64:
        	return ((Long)value).intValue();
        case DataType.DATA_T_FLOAT:
            return ((Float)value).intValue();
        case DataType.DATA_T_DOUBLE:
            return ((Double)value).intValue();
        case DataType.DATA_T_STRING:
        	try {
        		return Integer.parseInt(((String)value));
            }
            catch (Exception ex) {
            	return 0;
            }
        default:
            return 0;
        }
	}
	
	public long toLong()
	{
		switch (dataType)
        {
        case DataType.DATA_T_INT32:
            return ((Integer)value).longValue();
        case DataType.DATA_T_INT64:
        	return ((Long)value).longValue();
        case DataType.DATA_T_FLOAT:
            return ((Float)value).longValue();
        case DataType.DATA_T_DOUBLE:
            return ((Double)value).longValue();
        case DataType.DATA_T_STRING:
        	try {
        		return Long.parseLong(((String)value));
            }
            catch (Exception ex) {
            	return 0;
            }
        default:
            return 0;
        }
	}
	
	public float toFloat()
	{
		switch (dataType)
        {
        case DataType.DATA_T_INT32:
            return ((Integer)value).floatValue();
        case DataType.DATA_T_INT64:
        	return ((Long)value).floatValue();
        case DataType.DATA_T_FLOAT:
            return ((Float)value).floatValue();
        case DataType.DATA_T_DOUBLE:
            return ((Double)value).floatValue();
        case DataType.DATA_T_STRING:
        	try {
        		return Float.parseFloat(((String)value));
            }
            catch (Exception ex) {
            	return 0;
            }
        default:
            return 0;
        }
	}
	
	public double toDouble()
	{
		switch (dataType)
        {
        case DataType.DATA_T_INT32:
            return ((Integer)value).doubleValue();
        case DataType.DATA_T_INT64:
        	return ((Long)value).doubleValue();
        case DataType.DATA_T_FLOAT:
            return ((Float)value).doubleValue();
        case DataType.DATA_T_DOUBLE:
            return ((Double)value).doubleValue();
        case DataType.DATA_T_STRING:
        	try {
        		return Double.parseDouble(((String)value));
            }
            catch (Exception ex) {
            	return 0;
            }
        default:
            return 0;
        }
	}
	
	@Override
	public String toString()
	{
		switch (dataType)
        {
        case DataType.DATA_T_INT32:
        case DataType.DATA_T_INT64:
        case DataType.DATA_T_FLOAT:
        case DataType.DATA_T_DOUBLE:
            return value.toString();
        case DataType.DATA_T_STRING:
        	return (String)value;
        case DataType.DATA_T_BINARY:
        	return ((Buffer)value).getString();
        default:
            return "";
        }
	}
	
	public Buffer toBinary()
	{
		Buffer buffer = new Buffer();
		
		switch (dataType)
		{
		case DataType.DATA_T_INT32:
			buffer.setInteger(((Integer)value).intValue(), 0);
			break;
        case DataType.DATA_T_INT64:
        	buffer.setLong(((Long)value).longValue(), 0);
        	break;
        case DataType.DATA_T_FLOAT:
        	buffer.setFloat(((Float)value).floatValue(), 0);
        	break;
        case DataType.DATA_T_DOUBLE:
        	buffer.setDouble(((Double)value).doubleValue(), 0);
        case DataType.DATA_T_STRING:
        	buffer.setString((String)value, 0);
        	break;
		case DataType.DATA_T_BINARY:
			buffer = (Buffer)value;
		default:
			return new Buffer();
		}
		
		return buffer;
	}
}
