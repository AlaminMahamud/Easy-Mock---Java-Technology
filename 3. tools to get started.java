public interface Collaborator
{
	void documentAdded(String title);
}

public class ClassUnderTest
{
	private Collaborator listener;
	
	// ...

	public void SetListener(Collaborator listener)
	{
		this.listener = listener;
	}

	public void addDocument(String title, byte[] document)
	{
		// ...
	}
}