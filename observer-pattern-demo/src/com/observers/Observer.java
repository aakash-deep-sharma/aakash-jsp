package com.observers;

import com.subject.Subject;

public abstract class Observer {
	protected Subject subject;
	public abstract void update();
}
