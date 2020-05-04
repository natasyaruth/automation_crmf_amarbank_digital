package com.tunaiku.keyword

import java.util.function.Function;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// {{start:UpdatableBCrypt}}
public class UpdatableBCrypt {

	private static final Logger log = LoggerFactory.getLogger(UpdatableBCrypt.class);

	private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(11);

	private final int logRounds;

	public UpdatableBCrypt(int logRounds) {
		this.logRounds = logRounds;
	}

	public String hash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(logRounds));
	}

	/*
	 * Copy pasted from BCrypt internals :(. Ideally a method
	 * to exports parts would be public. We only care about rounds
	 * currently.
	 */
	private int getRounds(String salt) {
		char minor = (char)0;
		int off = 0;

		if (salt.charAt(0) != '$' || salt.charAt(1) != '2')
			throw new IllegalArgumentException ("Invalid salt version");
		if (salt.charAt(2) == '$')
			off = 3;
		else {
			minor = salt.charAt(2);
			if (minor != 'a' || salt.charAt(3) != '$')
				throw new IllegalArgumentException ("Invalid salt revision");
			off = 4;
		}

		// Extract number of rounds
		if (salt.charAt(off + 2) > '$')
			throw new IllegalArgumentException ("Missing salt rounds");
		return Integer.parseInt(salt.substring(off, off + 2));
	}
}
// {{end:UpdatableBCrypt}}