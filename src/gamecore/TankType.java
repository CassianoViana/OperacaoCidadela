package gamecore;

public enum TankType implements Shooter {
	STRONG {
		@Override
		public Shoot shoot(GameObject go) {
			Shoot shoot = new Shoot(go);
			shoot.speed = 10;
			shoot.time = 3;
			return shoot;
		}
	},
	DYING {
		@Override
		public Shoot shoot(GameObject go) {
			Shoot shoot = new Shoot(go);
			shoot.speed = 5;
			shoot.time = 3;
			return shoot;
		}
	}

}
