package fun.bb1.registry;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
 * A simple implementation of {@link IRegistry}
 * 
 * @author BradBot_1
 */
public class SimpleRegistry<K, T> implements IRegistry<K, T> {
	
	protected final @NotNull Map<K, T> map = new ConcurrentHashMap<K, T>();
	
	@Override
	public @Nullable T register(final @NotNull K identifier, final T registree) {
		map.put(identifier, registree);
		this.onRegister(identifier, registree);
		return registree;
	}

	@Override
	public @Nullable T get(final @NotNull K identifier) {
		return this.map.get(identifier);
	}

	@Override
	public @Nullable T unregister(final @NotNull K identifier) {
		return this.map.remove(identifier);
	}

	@Override
	public boolean contains(final @NotNull K identifier) {
		return this.map.containsKey(identifier);
	}

	@Override
	public @NotNull Collection<K> getAllKeys() {
		return this.map.keySet();
	}

	@Override
	public @NotNull Collection<T> getAllValues() {
		return this.map.values();
	}
	
}
