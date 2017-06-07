/**
 * Copyright (c) 2011 bjaxt. All Rights Reserved.
 */

package com.axt.util;

public class Buffer 
{
	private byte buffer[] = null;
	
	public Buffer()
	{
	}
	
	public Buffer(int size)
	{
		if (size > 0)
			buffer = new byte[size];
	}
	
	public Buffer(byte buf[])
	{
		if (buf != null && buf.length > 0)
			this.buffer = buf;
		else
			this.buffer = null;

	}
	
	public byte[] getData()
	{
		return getData(0, getSize());
	}
	
	public byte[] getData(int pos, int size)
	{
		if (pos < 0 || pos >= getSize() || size <= 0 || pos + size > getSize())
			return null;
		
		byte buf[] = new byte[size];
		System.arraycopy(this.buffer, pos, buf, 0, size);
		
		return buf;
	}
	
	public int getSize()
	{
		if (null == buffer)
			return 0;
		
		return buffer.length;
	}
	
	public void setData(byte buf[])
	{
		if (null != buf)
			setData(buf, buf.length, 0);
	}
	
	public void setData(byte buf[], int size)
	{
		setData(buf, size, 0);
	}
	
	public void setData(byte buf[], int size, int pos)
	{
		if (pos < 0 || buf == null || buf.length == 0 || size <= 0)
			return;
		
		size = Math.min(size, buf.length);
		
		if (pos + size > getSize())
			setSize(pos + size, true);
		
		System.arraycopy(buf, 0, this.buffer, pos, size);
	}
	
	public void setData(Buffer buf)
	{
		if (null != buf)
			setData(buf.getData());
	}
	
	public void setData(Buffer buf, int size, int pos)
	{
		if (null != buf)
			setData(buf.getData(), buf.getSize(), pos);
	}
	
	public void append(byte buf[])
	{
		if (null != buf)
			setData(buf, buf.length, getSize());
	}
	
	public void append(byte buf[], int size)
	{
		setData(buf, size, getSize());
	}
	
	public void append(Buffer buf)
	{
		if (null != buf)
			setData(buf.getData(), buf.getSize(), getSize());
	}
	
	public void append(Buffer buf, int size)
	{
		if (null != buf)
			setData(buf.getData(), size, getSize());
	}
	
	public void setSize(int size, boolean copyOldData)
	{
		if (size == getSize())
			return;
		
		if (size <= 0)
		{
			this.buffer = null;
			return;
		}
		
		/* create new buffer */
		byte newBuf[] = new byte[size];
		if (null != this.buffer && copyOldData)
			System.arraycopy(this.buffer, 0, newBuf, 0, Math.min(this.buffer.length, size));
		
		this.buffer = newBuf;
	}
	
	public void setMemory(byte c)
	{
		int size = getSize();
		
		for (int i = 0; i < size; i ++)
			this.buffer[i] = c;
	}
	
	public void setByte(byte b, int pos)
	{
		byte buf[] = new byte[1];
		buf[0] = b;
		setData(buf, 1, pos);
	}
	
	public void setByte(byte b)
	{
		setByte(b, 0);
	}
	
	public byte getByte(int pos)
	{
		byte buf[] = getData(pos, 1);
		if (null == buf || buf.length != 1)
			return 0;
		
		return buf[0];
	}
	
	public byte getByte()
	{
		return getByte(0);
	}
	
	public void setShort(short s, int pos)
	{
		byte buf[] = new byte[2];
		for (int i = 0; i < 2; i ++)
		{
			buf[i] = (byte)(s&0xFF);
			s = (short)(s >> 8);
		}
		
		setData(buf, 2, pos);
	}
	
	public void setShort(short s)
	{
		setShort(s, 0);
	}
	
	public short getShort(int pos)
	{
		byte buf[] = getData(pos, 2);
		if (null == buf || buf.length != 2)
			return 0;
		
		short s = 0;
		for (int i = 1; i >= 0; i --)
		{
			s = (short)(s << 8);
			s += (short)((buf[i]&0xFF));
		}
		
		return s;
	}
	
	public short getShort()
	{
		return getShort(0);
	}
	
	public void setInteger(int n, int pos)
	{
		byte buf[] = new byte[4];
		for (int i = 0; i < 4; i ++)
		{
			buf[i] = (byte)(n&0xFF);
			n = n >> 8;
		}
		
		setData(buf, 4, pos);
	}
	
	public void setInteger(int n)
	{
		setInteger(n, 0);
	}
	
	public int getInteger(int pos)
	{
		byte buf[] = getData(pos, 4);
		if (null == buf || buf.length != 4)
			return 0;
		
		int n = 0;
		for (int i = 3; i >= 0; i --)
		{
			n = n << 8;
			n += ((buf[i]&0xFF));
		}
		
		return n;
	}
	
	public int getInteger()
	{
		return getInteger(0);
	}
	
	public void setLong(long l, int pos)
	{
		byte buf[] = new byte[8];
		for (int i = 0; i < 8; i ++)
		{
			buf[i] = (byte)(l&0xFF);
			l = l >> 8;
		}
		
		setData(buf, 8, pos);
	}
	
	public void setLong(long l)
	{
		setLong(l, 0);
	}
	
	public long getLong(int pos)
	{
		byte buf[] = getData(pos, 8);
		if (null == buf || buf.length != 8)
			return 0;
		
		long l = 0;
		for (int i = 7; i >= 0; i --)
		{
			l = l << 8;
			l += ((buf[i]&0xFF));
		}
		
		return l;
	}
	
	public long getLong()
	{
		return getLong(0);
	}
	
	public void setFloat(float f, int pos)
	{
		int n = Float.floatToIntBits(f);
		setInteger(n, pos);
	}
	
	public void setFloat(float f)
	{
		setFloat(f, 0);
	}
	
	public float getFloat(int pos)
	{
		int n = getInteger(pos);
		return Float.intBitsToFloat(n);
	}
	
	public float getFloat()
	{
		return getFloat(0);
	}
	
	public void setDouble(double d, int pos)
	{
		long l = Double.doubleToLongBits(d);
		setLong(l, pos);
	}
	
	public void setDouble(double d)
	{
		setDouble(d, 0);
	}
	
	public double getDouble(int pos)
	{
		long l = getLong(pos);
		return Double.longBitsToDouble(l);
	}
	
	public double getDouble()
	{
		return getDouble(0);
	}
	
	public void setString(String s, int pos)
	{
		byte buf[] = s.getBytes();
		if (null != buf)
			setData(buf, buf.length, pos);
	}
	
	public void setString(String s)
	{
		setString(s, 0);
	}
	
	public String getString(int pos, int size)
	{
		byte buf[] = getData(pos, size);
		if (null == buf || buf.length != size)
			return "";
		
		return new String(buf, 0, size);
	}
	
	public String getString()
	{
		return getString(0, getSize());
	}
	
	public void setBuffer(Buffer buf, int pos)
	{
		if (null != buf)
			setData(buf.getData(), buf.getSize(), pos);
	}
	
	public void setBuffer(Buffer buf)
	{
		setBuffer(buf, 0);
	}
	
	public Buffer getBuffer(int pos, int size)
	{
		return new Buffer(getData(pos, size));
	}
	
	public Buffer getBuffer()
	{
		return getBuffer(0, getSize());
	}
}
