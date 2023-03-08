package physics2dtmp.forces;

import physics2d.components.Rigidbody2D;

public interface ForceGenerator {
	void updateForce(Rigidbody2D body, float dt);
}