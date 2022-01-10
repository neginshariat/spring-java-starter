package com.javaExample.starterfirst.dao;

import java.util.UUID;

public interface UuidSource {
	   public static UuidSource random() {
	        return UUID::randomUUID;
	    }

	    UUID newUuid();
}
