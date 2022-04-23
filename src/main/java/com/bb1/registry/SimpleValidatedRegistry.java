package com.bb1.registry;

import java.util.function.BiPredicate;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 
 * Copyright 2022 BradBot_1
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * A simple implementation of {@link IValidatedRegistry}
 * 
 * @author BradBot_1
 */
public class SimpleValidatedRegistry<K, T> extends SimpleRegistry<K, T> implements IValidatedRegistry<K, T> {
	
	protected final @NotNull BiPredicate<T, K> validate;
	
	public SimpleValidatedRegistry(final @NotNull BiPredicate<T, K> validator) {
		this.validate = validator;
	}
	
	@Override
	public @Nullable T register(final @NotNull K identifier, final @NotNull T registree) {
		if (!validate(identifier, registree)) return null;
		return super.register(identifier, registree);
	}

	@Override
	public boolean validate(final @NotNull K identifier, final @NotNull T value) {
		return this.validate.test(value, identifier);
	}

}
