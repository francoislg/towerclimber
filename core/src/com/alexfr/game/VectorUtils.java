package com.alexfr.game;

import com.badlogic.gdx.math.Vector2;

public class VectorUtils {
	public static void ClampVector(Vector2 vector, Vector2 limit){
		if(vector.x > limit.x){
			vector.set(limit.x, vector.y);
		}else if(vector.x < -limit.x){
			vector.set(-limit.x, vector.y);
		}
		if(vector.y > limit.y){
			vector.set(vector.x, limit.y);
		}else if(vector.y < -limit.y){
			vector.set(vector.x, -limit.y);
		}
	}
}
