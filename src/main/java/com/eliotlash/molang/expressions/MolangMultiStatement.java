package com.eliotlash.molang.expressions;

import java.util.*;

import com.eliotlash.mclib.math.Variable;
import com.eliotlash.molang.MolangParser;

public class MolangMultiStatement extends MolangExpression {
	public List<MolangExpression> expressions = new ArrayList<MolangExpression>();
	public Map<String, Variable> locals = new HashMap<String, Variable>();

	public MolangMultiStatement(MolangParser context) {
		super(context);
	}

	@Override
	public double get() {
		double value = 0;

		for (MolangExpression expression : this.expressions) {
			value = expression.get();
		}

		return value;
	}

	@Override
	public String toString() {
		StringJoiner builder = new StringJoiner("; ");

		for (MolangExpression expression : this.expressions) {
			builder.add(expression.toString());

			if (expression instanceof MolangValue && ((MolangValue) expression).returns) {
				break;
			}
		}

		return builder.toString();
	}
}
