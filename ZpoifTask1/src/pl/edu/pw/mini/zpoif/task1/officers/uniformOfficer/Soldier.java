package pl.edu.pw.mini.zpoif.task1.officers.uniformOfficer;


public class Soldier extends UniformOfficer {

	public Soldier() {
		setColor(Color.values()[random.nextInt(1, 3)]);
		init();
	}
	
	@Override
	public void doJob() {
		new Grenadable() {

			@Override
			public void explode() {
				// TODO Auto-generated method stub
				
			}
			
		}.explode();
	}

	@Override
	public void init() {
		System.out.println("Zolnierza inicjowac nie trzeba!");
	}
	
	private class Grenade implements Grenadable {
		@Override
		public void explode() {
			System.out.println("Boom!");
		}
	}
	
	private interface Grenadable {
		public void explode();
	}
}
