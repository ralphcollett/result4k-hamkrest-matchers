# result4k-hamkrest-matchers

[Result4k](https://github.com/npryce/result4k/) [Hamkrest](https://github.com/npryce/hamkrest) matchers.

[![Build Status](https://app.travis-ci.com/ralphcollett/result4k-hamkrest-matchers.svg?branch=main)](https://app.travis-ci.com/ralphcollett/result4k-hamkrest-matchers)
[![Maven Central](https://img.shields.io/maven-central/v/com.ralphcollett/result4k-hamkrest-matchers.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.ralphcollett%22%20AND%20a%3A%22result4k-hamkrest-matchers%22)

## Example usage

```kotlin
val result: Result<Int, String> = TODO()
assertThat(result, isSuccess())
assertThat(result, isSuccess(1))
assertThat(result, isSuccess(greaterThan(0)))
assertThat(result, isFailure())
assertThat(result, isFailure("12345"))
assertThat(result, isFailure(startsWith("123")))
```

Uses imports

```
import com.ralphcollett.matchers.isFailure
import com.ralphcollett.matchers.isSuccess
import com.natpryce.hamkrest.greaterThan
import com.natpryce.hamkrest.startsWith
import com.natpryce.hamkrest.assertion.assertThat
import dev.forkhandles.result4k.Result
import org.junit.jupiter.api.Test
```

## Download

Group Id: ```com.ralphcollett```

Artifact Id: ```result4k-hamkrest-matchers```

More instructions: [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.ralphcollett%22%20AND%20a%3A%22result4k-hamkrest-matchers%22)