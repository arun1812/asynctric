package com.asynctric.qa.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import com.asynctric.qa.base.TestBase;

public class CommonMethod extends TestBase{

	
	public CommonMethod() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String windowhandle()
	{
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String	Parentwindow=it.next();
		String	ChildWindow=it.next();
		return ChildWindow;
	}
}
