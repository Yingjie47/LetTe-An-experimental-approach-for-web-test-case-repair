from time import sleep
from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.get("http://localhost/admidio-4.2.13/")
driver.find_element(By.XPATH, '//*[@id="plg_usr_login_name"]').send_keys("admin")
driver.find_element(By.XPATH, '//*[@id="plg_usr_password"]').send_keys("admin123")
driver.find_element(By.XPATH, '//*[@id="next_page"]').click()
# sleep(1)
driver.find_element(By.XPATH, '//*[@id="admidio-overview"]/div[1]/div').click()
driver.find_element(By.XPATH, '//*[@id="dates"]').click()
driver.find_element(By.XPATH, '//*[@id="dropdownMenuButton"]').click()
driver.find_element(By.XPATH, '/html/body/div[3]/div/div[2]/div/div[2]/div[1]/div/div/a[3]').click()
driver.find_element(By.XPATH, '//*[@id="dat_headline"]').send_keys("123")
driver.find_element(By.XPATH, '//*[@id="dat_all_day"]').click()
driver.find_element(By.XPATH, '//*[@id="cat_uuid"]').click()
driver.find_element(By.XPATH, '//*[@id="cat_uuid"]/option[2]').click()
driver.find_element(By.XPATH, '//*[@id="dat_highlight"]').click()
driver.find_element(By.XPATH, '//*[@id="btn_save"]').click()
# sleep(1)
driver.find_element(By.XPATH, '//*[@id="navbarNav"]/ul/li[2]/a').click()
driver.close()
driver.quit()