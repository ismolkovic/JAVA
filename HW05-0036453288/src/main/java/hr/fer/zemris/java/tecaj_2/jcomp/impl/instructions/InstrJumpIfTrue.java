package hr.fer.zemris.java.tecaj_2.jcomp.impl.instructions;

import java.util.List;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.Instruction;
import hr.fer.zemris.java.tecaj_2.jcomp.InstructionArgument;

/**
 * Razred <code>InstrJumpIfTrue</code> omogućava postavljanje 
 * programskog brojila na proizvoljnu vrijednost ukoliko je
 * zastavica postavljena na true.
 * 
 * <pre>
 * 	jumpIfTrue lokacija;
 * </pre>
 * 
 * @author Igor Smolkovič
 * @version 1.0
 *
 */
public class InstrJumpIfTrue implements Instruction {
	/**
	 * Memorijska lokacija.
	 */
	private int location;

	
	/**
	 * Konstruktor razreda <code>InstrJumpIftrue</code> prima listu
	 * argumenata.
	 * 
	 * @param arguments Lista argumenata.
	 * @throws IllegalArgumentException ako lista ne sadrži 1 element
	 * 			ili jedini element nije memorijska lokacija.
	 */
	public InstrJumpIfTrue(List<InstructionArgument> arguments) {
		if(arguments.size() != 1) {
			throw new IllegalArgumentException("Expected 1 arguments");
		}
		if(!arguments.get(0).isNumber()) {
			throw new IllegalArgumentException("Type mismatch for argument 0!");
		}
		
		this.location = ((Integer)arguments.get(0).getValue()).intValue();
	}
	
	
	/**
	 * Metoda koja pokreće izvršavanje instrukcije jumpIfTrue.
	 * 
	 * @param computer Referenca na računalo.
	 * @return false jer nije potrebno zaustaviti rad procesora.
	 */
	@Override
	public boolean execute(Computer computer) {
		boolean flag = computer.getRegisters().getFlag();
		if(flag == true) {
			computer.getRegisters().setProgramCounter(location);
		}
		
		return false;
	}

}
