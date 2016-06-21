package core;

import java.awt.image.BufferedImage;

import resources.R;

public enum Teams {

	GERMANY {
		private final BufferedImage tankImage = R.load(R.TANK_1);
		@Override
		public String getName() {
			return "GERMANY";
		}

		@Override
		public BufferedImage getImage() {
			return tankImage;
		}
	},
	URSS {
		private final BufferedImage tankImage = R.load(R.TANK_2);
		@Override
		public String getName() {
			return "URSS";
		}

		@Override
		public BufferedImage getImage() {
			return tankImage;
		}
	};
	
	public abstract String getName();
	public abstract BufferedImage getImage();
}
