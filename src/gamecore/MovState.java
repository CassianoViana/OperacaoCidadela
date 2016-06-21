package gamecore;

	public enum MovState implements Motor {
	GOING_TO_FRONT {
		@Override
		public void move(GameObject go) {
			double anguloEmRadianos = Math.toRadians(go.anguloFace);
			
			go.direction.x = (float) Math.cos(anguloEmRadianos);
			go.direction.y = (float) Math.sin(anguloEmRadianos);

			go.velocity.x = (float) (go.direction.x * go.speed);
			go.velocity.y = (float) (go.direction.y * go.speed);
			
			go.position.x += go.velocity.x * go.time;
			go.position.y += go.velocity.y * go.time;
			
			go.x = (int) go.position.x;
			go.y = (int) go.position.y;
		}
	},
	GOING_TO_BACK {
		@Override
		public void move(GameObject go) {
			double anguloEmRadianos = Math.toRadians(go.anguloFace);
			go.x -= Math.cos(anguloEmRadianos) * go.speed;
			go.y -= Math.sin(anguloEmRadianos) * go.speed;
			go.direction.x = (float) Math.cos(anguloEmRadianos);
			go.direction.y = (float) Math.sin(anguloEmRadianos);

			go.velocity.x = (float) (go.direction.x * go.speed);
			go.velocity.y = (float) (go.direction.y * go.speed);
			
			go.position.x -= go.velocity.x * go.time;
			go.position.y -= go.velocity.y * go.time;
			
			go.x = (int) go.position.x;
			go.y = (int) go.position.y;
		}
	},
	TURNING_RIGHT {
		@Override
		public void move(GameObject gameObject) {
			gameObject.anguloFace += gameObject.velTurning;
		}
	},
	TURNING_LEFT {
		@Override
		public void move(GameObject gameObject) {
			gameObject.anguloFace -= gameObject.velTurning;
		}
	}
}