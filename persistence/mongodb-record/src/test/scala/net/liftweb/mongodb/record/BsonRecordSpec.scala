/*
 * Copyright 2010-2020 WorldWide Conferencing, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.liftweb
package mongodb
package record

import org.specs2.mutable.Specification

class BsonRecordSpec extends Specification with MongoTestKit {
  "BsonRecordSpec Specification".title

  import fixtures._
  import testmodels._

  override def before = {
    super.before
    checkMongoIsRunning
  }

  "BsonRecord" should {
    "compare properly with set values" in {

      val subRec = SubSubRecord.createRecord.name("subrecord")
      val subRec2 = SubSubRecord.createRecord.name("subrecord")

      (subRec == subRec2) must_== true

      subRec2.name("subrecord2")

      (subRec == subRec2) must_== false

    }

    "compare properly with default values" in {
      val subRec = SubSubRecord.createRecord
      val subRec2 = SubSubRecord.createRecord

      (subRec == subRec2) must_== true
    }
  }
}
