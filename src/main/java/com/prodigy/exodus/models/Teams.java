package com.prodigy.exodus.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teams {
	
	private List<Heroes> avengers;
	private List<Heroes> xmen;

}
