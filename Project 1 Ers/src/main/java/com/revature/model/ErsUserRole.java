package com.revature.model;

import java.util.HashMap;
import java.util.Map;

public enum ErsUserRole {

	EMPLOYEE(0), 
	MANAGER(1);
	
	private final int id;
	
	private ErsUserRole(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	private static final Map<Integer,ErsUserRole> map;
    static {
        map = new HashMap<Integer,ErsUserRole>();
        for (ErsUserRole role : ErsUserRole.values()) {
            map.put(role.id, role);
        }
    }
    public static ErsUserRole findById(int i) {
        return map.get(i);
    }
    
    public static ErsUserRole getOppositeRole(ErsUserRole role) {
    	switch(role) {
    	case EMPLOYEE: return MANAGER;
    	case MANAGER: return EMPLOYEE;
    	default: return null;
    	}
    }

	
}
