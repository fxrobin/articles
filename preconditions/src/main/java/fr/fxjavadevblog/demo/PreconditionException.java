package fr.fxjavadevblog.demo;

public enum PreconditionException
{

	NOT_NULL("L'argument %s ne peut pas être nul"), NAME_MAJUSCULES("L'argument %s doit être en majuscules");

	private final String message;

	private PreconditionException(String message)
	{
		this.message = message;
	}

	public IllegalArgumentException build(String replace)
	{
		return new IllegalArgumentException(String.format(message, replace));
	}

}
