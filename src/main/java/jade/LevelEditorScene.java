package jade;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_INFO_LOG_LENGTH;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glShaderSource;

public class LevelEditorScene extends Scene {
	private String vertexShaderSrc = "#version 330 core\n" + "layout (location=0) in vec3 aPos;\n"
			+ "layout (location=1) in vec4 aColor;\n" + "\n" + "out vec4 fColor;\n" + "\n" + "void main()\n" + "{\n"
			+ "     fColor = aColor;\n" + "     gl_Position = vec4(aPos, 1.0);\n" + "}";

	private String fragmentShaderSrc = "#version 330 core\n" + "\n" + "in vec4 fColor;\n" + "\n" + "out vec4 color;\n"
			+ "\n" + "void main()\n" + "{\n" + "    color = fColor;\n" + "}";

	private int vertexID, fragmentID, shaderProgram;

	private float[] vertexArray = {
			// position //color
			0.5f, -0.5f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, // Bottom right
			-0.5f, 0.5f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, // Top left

	};

	public LevelEditorScene() {

	}

	@Override
	public void init() {
		// =======================================================
		// Compile and link shader
		// =======================================================

		// First load and compile the vertex shader
		vertexID = glCreateShader(GL_VERTEX_SHADER);
		// Pass the shader source to the GPU
		glShaderSource(vertexID, vertexShaderSrc);
		glCompileShader(vertexID);

		// Check for errors in compilation
		int success = glGetShaderi(vertexID, GL_COMPILE_STATUS);
		if (success == GL_FALSE) {
			int len = glGetShaderi(vertexID, GL_INFO_LOG_LENGTH);
			System.out.println("ERROR: 'defaultShader.glsl'\n\tVertex shader compilation failed.");
			System.out.println(glGetShaderInfoLog(vertexID, len));
			assert false : "";
		}

		// First load and compile the fragment shader
		fragmentID = glCreateShader(GL_FRAGMENT_SHADER);
		// Pass the Shader source to the GPU
		glShaderSource(fragmentID, fragmentShaderSrc);
		glCompileShader(fragmentID);

		// Check for errors in compilation
		success = glGetShaderi(fragmentID, GL_COMPILE_STATUS);
		if (success == GL_FALSE) {
			int len = glGetShaderi(fragmentID, GL_INFO_LOG_LENGTH);
			System.out.println("ERROR: 'defaultShader.glsl'\n\tFragment shader compilation failed.");
			System.out.println(glGetShaderInfoLog(fragmentID, len));
			assert false : "";
		}
	}

	@Override
	public void update(float dt) {

	}

}