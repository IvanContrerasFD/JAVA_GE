package ge.core.operator.mutation;

import ge.core.problem.Solution;
import ge.core.problem.Variable;
/**
 * El operador de mutación también requiere genéricos porque se accede a las variables.
 * @author jlrisco
 * @param <T>
 */
public abstract class MutationOperator<T extends Variable<?>> {
	protected double probability;
	
	public MutationOperator(double probability) {
		this.probability = probability;
	}
	
	public void setProbability(double probability) {
		this.probability = probability;
	}

	abstract public Solution<T> execute(Solution<T> solution);
}
