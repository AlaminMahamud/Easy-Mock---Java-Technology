/*

// Purpose

In our Case
	
	1. Create the Mock
	2. Have it set to the tested class
	3. Record what we expect the mock to do
	4. Tell all mocks we are now doing the actual testing
	5. Test
	6. Make sure everything that was supposed to be called was called

*/


import static org.easymock.EasyMock.*;

import org.easymock.*;

import org.junit.Rule;

import org.junit.Test;


public class ExampleTest extends EasyMockSupport
{
	
	@Rule
	public EasyMockRule rule = new EasyMockRule(this);

	@Mock
	private Collaborator collaborator; //1

	@TestSubject
	private final ClassTested classUnderTest = new ClassTested(); // 2


	@Test
	public void addDocument()
	{
		colllaborator.documentAdded("New Document");  // 3
		replayAll(); // 4
		classUnderTest.addDocument("New document" , "content"); // 5
		verifyAll(); //6
	}

}