package com.team1.insta.user.dto;


import lombok.Data;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class KeyConfirm {
	String keyType;
	String key;
}
