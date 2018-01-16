package com.revature.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ErsReimbursementStatus {
	
	PENDING(0),
	APPROVED(1),
	DENIED(2),
	//ONLY USED WITH SERVICE GETREIMBURSEMENT METHODS TO GET ALL REIMBURSEMENTS 
	RESOLVED(3),	
	ALL(4);
	
	private final int id;
	
	private ErsReimbursementStatus(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	private static final Map<Integer, ErsReimbursementStatus> map;
    static {
        map = new HashMap<Integer, ErsReimbursementStatus>();
        for (ErsReimbursementStatus status : ErsReimbursementStatus.values()) {
            map.put(status.id, status);
        }
    }
    public static ErsReimbursementStatus findById(int i) {
        return map.get(i);
    }
    
    private static Map<String, ErsReimbursementStatus> namesMap = new HashMap<String, ErsReimbursementStatus>(3);

    static {
        namesMap.put("pending", PENDING);
        namesMap.put("approved", APPROVED);
        namesMap.put("denied", DENIED);
        namesMap.put("resolved", RESOLVED);
        namesMap.put("all", ALL);
    }

    @JsonCreator
    public static ErsReimbursementStatus forValue(String value) {
        return namesMap.get(value.toLowerCase());
    }

    @JsonValue
    public String toValue() {
        for (Entry<String, ErsReimbursementStatus> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }

        return null; // or fail
    }
    
    public boolean equals(ErsReimbursementStatus other) {
    	if (other == ALL) return true;
    	if (other == RESOLVED) return (this == APPROVED || this == DENIED);
    	return (this == other);
    }

}
