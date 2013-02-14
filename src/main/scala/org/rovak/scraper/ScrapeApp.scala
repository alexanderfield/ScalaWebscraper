package org.rovak.scraper

import akka.actor._
import org.rovak.scraper.storage.Email
import org.rovak.scraper.storage.DatabaseStorage

/**
 * Main
 */
object ScrapeApp extends App {

  val system = ActorSystem()
  val scraper = system.actorOf(Props[scrapers.WebsiteScraper])
  val database = system.actorOf(Props[DatabaseStorage])
  val google = system.actorOf(Props[scrapers.GoogleScraper])
  
  println("Starting!")

  var searchTerms: List[String] = List("scala", "php", "javascript")

  //google ! scrapers.SearchTerms(searchTerms)
  database ! Email("test@test.nl", 5)

  println("Scrape request send!")
}